local function beta_text(obj)
    local gameObject = CS.UnityEngine.GameObject.Find("UIRoot/AboveDialog/BetaHintDialog(Clone)")

    if gameObject then
        local textComponent = gameObject:GetComponentInChildren(typeof(CS.RPG.Client.LocalizedText))

        if textComponent then
            uid = textComponent.text
            -- Check if it has been replaced
            if not uid:find("GlazePS UID:") then
                uid = uid:gsub("UID:", "<b><color=#FF0000>免费服务 禁止倒卖</color>\r\n<color=#C119B1>GlazePS UID: </color></b>")
                --version
               -- uid = uid:gsub("CNBETAWin2.0.54_D6648440_A6635239_L6635795", "")
                --uid = uid:gsub(" ", "")
                textComponent.text = "<b><color=#00E6CF>"..uid.."</color></b>"
            end
        else
            log:write("No Text component found on the game object") 
        end
    else
         log:write("Game object not found")
    end
end

local function mhy_text(obj)
    local gameObject = CS.UnityEngine.GameObject.Find("MHYText")

    if gameObject then
        local textComponent = gameObject:GetComponentInChildren(typeof(CS.RPG.Client.LocalizedText))

        if textComponent then
            textComponent.text = "GURALEAK"
            textComponent.visible = true
        else
            -- log:write("No Text component found on the game object")
        end
    else
        -- log:write("Game object not found")
    end
end

beta_text()
mhy_text()
