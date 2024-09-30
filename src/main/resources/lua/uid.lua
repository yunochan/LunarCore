local function beta_text(obj)
    local gameObject = CS.UnityEngine.GameObject.Find("UIRoot/AboveDialog/BetaHintDialog(Clone)")

    if gameObject then
        local textComponent = gameObject:GetComponentInChildren(typeof(CS.RPG.Client.LocalizedText))

        if textComponent then
            uid = textComponent.text
            -- Check if it has been replaced
             if not string.match(uid, "GlazePS") then
                uid = uid:gsub("UID:", "<b><color=#FF0000>本服务由琉璃社区免费提供 QQ群: 929259728</color>\r\n<color=#00E6CF>免费公益 禁止倒卖 </color><color=#FFA500><i>GlazePS</i> UID: </color></b>")
                textComponent.text = "<b><color=#FF4500>"..uid.."</color></b>"
				textComponent.fontSize = 76.0
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
