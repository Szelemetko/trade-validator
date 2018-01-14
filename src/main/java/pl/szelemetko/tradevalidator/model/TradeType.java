package pl.szelemetko.tradevalidator.model;

import java.util.Arrays;
import java.util.List;

// string constants instead of enums because enums can't be used as value for annotation property in Trade class
public class TradeType {
	public static final String SPOT = "Spot";
	public static final String FORWARD = "Forward";
	public static final String OPTION = "VanillaOption";

	public static List<String> values() {
		return Arrays.asList(SPOT, FORWARD, OPTION);
	}

}
