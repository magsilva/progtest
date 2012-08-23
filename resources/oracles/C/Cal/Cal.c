#include "Cal.h"

unsigned char isLeap(short int yr) {
	if (yr <= 1752) {
		if (yr % 4 == 0)
			return 1;
		else
			return 0;
	} else {
		if ((yr % 400 == 0) || ((yr % 4 == 0) && !(yr % 100 == 0)))
			return 1;
		else
			return 0;
	}
}

short int jan1(short int y) {
	int d, wd;
	d = y - 2;
	wd = d + ((y - 1) / 4);
	if(y > 1752)
		wd -= (((y - 1) - 1700) / 100) - (((y - 1) - 1600) / 400) + 4;
	return wd %= 7;
}

short int numberOfDays(short int m, short int y) {
	if (isLeap(y) && m == 2)
		return 29;
	else if (m == 2)
		return 28;
	else if (m == 4 || m == 6 || m == 9 || m == 11)
		return 30;
	else
		return 31;
}

short int firstOfMonth(short int m, short int y) {
	int k, i;
	k = jan1(y);
	for (i = 1; i < m; i++)
		k += numberOfDays(i ,y);
	return k % 7;
}

unsigned char cal(short int day, short int month, short int year) {
	int dow = 0;
	if(year < 1 || year > 9999 || month < 1 || month > 12)
		return dow;
	else if(month == 1 && (day < 1 || day > 31))
		return dow;
	else if(month == 3 && (day < 1 || day > 31))
		return dow;
	else if(month == 4 && (day < 1 || day > 30))
		return dow;
	else if(month == 5 && (day < 1 || day > 31))
		return dow;
	else if(month == 6 && (day < 1 || day > 30))
		return dow;
	else if(month == 7 && (day < 1 || day > 31))
		return dow;
	else if(month == 8 && (day < 1 || day > 31))
		return dow;
	else if(month == 10 && (day < 1 || day > 31))
		return dow;
	else if(month == 11 && (day < 1 || day > 30))
		return dow;
	else if(month == 12 && (day < 1 || day > 31))
		return dow;
	else if(month == 2 && isLeap(year) && (day < 1 || day > 29))
		return dow;
	else if(month == 2 && !isLeap(year) && (day < 1 || day > 28))
		return dow;
	else if(month == 9 && year != 1752 && (day < 1 || day > 30))
		return dow;
	else if(month == 9 && year == 1752 && (day < 1 || (day > 2 && day < 14) || day > 30))
		return dow;
	else {
		if(month == 9 && year == 1752 && (day >= 14))
			day -= 11;
		dow = (firstOfMonth(month, year) + day) % 7;
		if (dow == 0)
			dow = 7;
		return dow;
	}
}

