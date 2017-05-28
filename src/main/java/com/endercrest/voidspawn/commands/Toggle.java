package com.endercrest.voidspawn.commands;

import com.endercrest.voidspawn.TeleportManager;
import org.bukkit.entity.Player;

import com.endercrest.voidspawn.VoidSpawn;

public class Toggle implements SubCommand {

    @Override
    public boolean onCommand(Player p, String[] args){
        if(p.hasPermission(permission())){
            boolean status = TeleportManager.getInstance().togglePlayer(p.getUniqueId());
            if(status){
                p.sendMessage(VoidSpawn.colorize(VoidSpawn.prefix + "Toggled teleport to: Off"));
            }else{
                p.sendMessage(VoidSpawn.colorize(VoidSpawn.prefix + "Toggled teleport to: On"));
            }
            return true;
        }else{
            p.sendMessage(VoidSpawn.colorize("&cYou do not have permission."));
            return false;
        }
    }

    @Override
    public String helpInfo(){
        return "/vs toggle - Turns off void teleport.";
    }

    @Override
    public String permission(){
        return "vs.player.toggle";
    }
}