package com.google.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPage {

	Properties prop;

	public ConfigPage() {

		prop = new Properties();

		String path = System.getProperty("user.dir") + "\\Configuration\\credentional.properties";

		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getURL() {
		return prop.getProperty("url");
	}

	public long getImplisiveWait() {

		String impWait = prop.getProperty("impwait");
		return Long.parseLong(impWait);

	}

	public long getPageloadWait() {
		String pLoadWait = prop.getProperty("loadwait");
		return Long.parseLong(pLoadWait);
	}

	public String getChromepath() {
		String chromePath = prop.getProperty("chromepath");
		return chromePath;
	}

	public String getFirefoxpath() {
		return prop.getProperty("firefoxpath");
	}
}
