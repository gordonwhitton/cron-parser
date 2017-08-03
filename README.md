# cron-parser
A Java cmd line application to parse and enumerate a cron string

The main method can be found in the CronParser.java class.

The main method takes a single argument, e.g. "*/15 0 1,15 * 1-5 /usr/bin/find", 

and outputs the the parsed string. e.g.

minute        0 15 30 45
hour          0
day of month  1 15
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find
