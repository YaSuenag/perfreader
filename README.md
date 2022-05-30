Parser for HotSpot jvmstat performance counter (hsperfdata)
![CodeQL](../../workflows/CodeQL/badge.svg)
===================

# How to Build

## Requirements

* JDK 16 or later
* Maven 3.6.3 or later

## Build

```
$ export JAVA_HOME=/path/to/jdk
$ mvn package
```

# How to use

* Save hsperfdata file

```
$ java -XX:+PerfDataSaveToFile -XX:PerfDataSaveFile=<filename> ...
```

* Parse saved hsperfdata

```
$ perfreader [hsperfdata]
```

# License

GNU General Public License v2
