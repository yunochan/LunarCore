package emu.lunarcore.server.http.handlers;

import org.jetbrains.annotations.NotNull;

import emu.lunarcore.LunarCore;
import emu.lunarcore.game.account.Account;
import emu.lunarcore.game.account.AccountHelper;
import emu.lunarcore.server.http.objects.LoginAccountReqJson;
import emu.lunarcore.server.http.objects.LoginResJson;
import emu.lunarcore.server.http.objects.LoginResJson.VerifyData;
import emu.lunarcore.util.JsonUtils;
import io.javalin.http.ContentType;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.net.InetAddress;
import java.net.UnknownHostException;
import io.javalin.http.Context;
import java.net.InetSocketAddress;

public class UsernameLoginHandler implements Handler {

    public UsernameLoginHandler() {

    }

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        // Setup response
        LoginResJson res = new LoginResJson();

        // Parse request
        LoginAccountReqJson req = JsonUtils.decode(ctx.body(), LoginAccountReqJson.class);
        //get ip
        String address = ctx.ip();
        // Validate
        if (req == null) {
            res.retcode = -202;
            res.message = "Error logging in";
            return;
        }

        // Login - Get account data
         Account account = LunarCore.getAccountDatabase().getObjectByField(Account.class, "_id", req.uid);

        if (account == null) {
            if (LunarCore.getConfig().getServerOptions().autoCreateAccount) {
                // Create the account.
                account = AccountHelper.createAccount(req.account, null, 0);
                res.message = "注册成功";
                res.data = new VerifyData(account.getUid(), account.getEmail(), account.generateDispatchToken());
                //Log the creation.
                 LunarCore.getLogger().info(String.format("客户端 %s 已注册账号 %s , ID为 %s ",address, account.getEmail(), account.getUid()));
                // Save User's IP
                account.setLastLoginIp(address);
				account.save();
            } else {
                res.retcode = -201;
                res.message = "账号未注册";
                //Log register failure
                LunarCore.getLogger().warn(String.format("客户端 %s 登录失败：账号不存在 ",address));
            }
        } else if (account.isBanned()) {
            res.retcode = -203;
            res.message = "您的账号已经封停，有任何问题请联系管理员";
            //Log login failure
            LunarCore.getLogger().warn(String.format("客户端 %s 登录账号 %s 失败：账号被封停", address, account.getEmail()));
        }else{
        try {
            if (account.getLastLoginIp() != null && !isSameIpPrefix(address, account.getLastLoginIp())) {
                LunarCore.getLogger().warn(String.format("账号 %s 异地登录，IP: %s -> %s", account.getEmail(), account.getLastLoginIp(), address));
                int count = account.getCount();
                account.setCount(count + 1);
            }
        } catch (UnknownHostException e) {
            LunarCore.getLogger().error("IP address parsing error", e);
        }

        account.setLastLoginIp(address);
        account.save();
            res.message = "OK";
            res.data = new VerifyData(account.getUid(), account.getEmail(), account.generateDispatchToken());
        }

        // Send result
        ctx.contentType(ContentType.APPLICATION_JSON);
        ctx.result(JsonUtils.encode(res));
    }
    
    private static String getClientIpPrefix(String ip) {
    if (ip == null) {
        return null;
    }
    try {
        InetAddress inetAddress = InetAddress.getByName(ip);
        if (inetAddress.getAddress().length == 4) {
            // IPv4 address
            String[] ipParts = ip.split("\\.");
            return ipParts[0] + "." + ipParts[1];
        } else {
            // IPv6 address
            String[] ipParts = ip.split(":");
            return ipParts[0] + ":" + ipParts[1] + ":" + ipParts[2] + ":" + ipParts[3];
        }
    } catch (UnknownHostException e) {
        LunarCore.getLogger().error("Error parsing IP address: " + ip, e);
        return null;
    }
}

private static boolean isSameIpPrefix(String ip1, String ip2) throws UnknownHostException {
    return getClientIpPrefix(ip1).equals(getClientIpPrefix(ip2));
}


}
