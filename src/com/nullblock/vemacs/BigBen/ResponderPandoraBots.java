package com.nullblock.vemacs.BigBen;

import org.bukkit.Bukkit;

public class ResponderPandoraBots implements Responder {

	private BigBen plugin;
	
	public ResponderPandoraBots(BigBen plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public String getResponse(String msg) {
		String xml = BongLib.getUrlSimple("http://www.pandorabots.com/pandora/talk-xml?botid=f6d4afd83e34564d&input="+msg);
		if(!xml.equals(""))
			return xml.split("<that>")[1].split("</that>")[0];
		else {
			Bukkit.getConsoleSender().sendMessage("PandoraBots has an issue, reverting back to random response!");
			return new ResponderRandom(plugin).getResponse(msg);
		}
	}

}
