package title.search;

public enum SearchDork {

	HOST("HOST"),
	PORT("PORT"),
	URL("URL"),
	STATUS("STATUS"),
	REQUEST("REQUEST"),
	RESPONSE("RESPONSE"),
	COMMENT("COMMENT"),

	REGEX("REGEX");//这个用于正则搜索


	private String dork;

	SearchDork(String dork){
		this.dork = dork;
	}

	public static boolean isDork(String input) {
		SearchDork[] values = SearchDork.values();
		for (SearchDork value:values) {
			if (value.toString().equalsIgnoreCase(input)) {
				return true;
			}
		}
		return false;
	}

	@Deprecated
	public static boolean isTagDork(String input) {
		SearchDork[] values = SearchDork.values();
		if (isRegDork(input)) {
			return false;
		}

		for (SearchDork value:values) {
			if (value.toString().equalsIgnoreCase(input)) {
				return true;
			}
		}
		return false;
	}

	@Deprecated
	public static boolean isRegDork(String input) {
		if (REGEX.toString().equalsIgnoreCase(input)) {
			return true;
		}else {
			return false;
		}
	}

	public static String grepDork(String input) {

		String[] arr = input.split(":",2);//limit =2 分割成2份
		if (arr.length ==2) {
			String dork = arr[0].trim();
			return dork;
		}else {
			return "";
		}
	}

	public static String grepKeyword(String input) {

		String[] arr = input.split(":",2);//limit =2 分割成2份
		if (arr.length ==2) {
			String keyword = arr[1].trim();
			return keyword;
		}else {
			return input;
		}
	}

	public static void main(String args[]) {
		isTagDork("aaa");
	}
}
