public class Cal {
	
	public static boolean isLeap(int yr) {
		if (yr <= 1752) {
			if (yr % 4 == 0)
				return true;
			else
				return false;
		} else {
			if ((yr % 400 == 0) || ((yr % 4 == 0) && !(yr % 100 == 0)))
				return true;
			else
				return false;
		}
	}
	
	public static int jan1(int y) {
		int d, wd;
		d = y - 2;
		wd = d + ((y - 1) / 4);
		if(y > 1752)
			wd -= (((y - 1) - 1700) / 100) - (((y - 1) - 1600) / 400) + 4;
		return wd %= 7;
	}
	
	public static int numberOfDays(int m, int y) {
		if (isLeap(y) && m == 2)
			return 29;
		else if (m == 2)
			return 28;
		else if (m == 4 || m == 6 || m == 9 || m == 11)
			return 30;
		else
			return 31;
	}
	
	public static int firstOfMonth(int m, int y) {
		int k, i;
		k = jan1(y);
		for (i = 1; i < m; i++)
			k += numberOfDays(i ,y);
		return k % 7;
	}
	
	public static int cal(int day, int month, int year) throws IllegalArgumentException {
		if(year < 1 || year > 9999 || month < 1 || month > 12)
			throw new IllegalArgumentException();
		else if(month == 1 && (day < 1 || day > 31))
			throw new IllegalArgumentException();
		else if(month == 3 && (day < 1 || day > 31))
			throw new IllegalArgumentException();
		else if(month == 4 && (day < 1 || day > 30))
			throw new IllegalArgumentException();
		else if(month == 5 && (day < 1 || day > 31))
			throw new IllegalArgumentException();
		else if(month == 6 && (day < 1 || day > 30))
			throw new IllegalArgumentException();
		else if(month == 7 && (day < 1 || day > 31))
			throw new IllegalArgumentException();
		else if(month == 8 && (day < 1 || day > 31))
			throw new IllegalArgumentException();
		else if(month == 10 && (day < 1 || day > 31))
			throw new IllegalArgumentException();
		else if(month == 11 && (day < 1 || day > 30))
			throw new IllegalArgumentException();
		else if(month == 12 && (day < 1 || day > 31))
			throw new IllegalArgumentException();
		else if(month == 2 && isLeap(year) && (day < 1 || day > 29))
			throw new IllegalArgumentException();
		else if(month == 2 && !isLeap(year) && (day < 1 || day > 28))
			throw new IllegalArgumentException();
		else if(month == 9 && year != 1752 && (day < 1 || day > 30))
			throw new IllegalArgumentException();
		else if(month == 9 && year == 1752 && (day < 1 || (day > 2 && day < 14) || day > 30))
			throw new IllegalArgumentException();
		else {
			if(month == 9 && year == 1752 && (day >= 14))
				day -= 11;
			int dow = (firstOfMonth(month, year) + day) % 7;
			if (dow == 0)
				dow = 7;
			return dow;
		}
	}

}
