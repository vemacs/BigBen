package com.nullblock.vemacs.BigBen;

import java.util.List;
import java.util.Random;

public class ResponderRandom implements Responder {

	private BigBen plugin;
	
	public ResponderRandom(BigBen plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public String getResponse(String msg) {
		List<String> resps = plugin.getConfig().getStringList("responses");
		return resps.get(new Random().nextInt(resps.size()));
	}

}
