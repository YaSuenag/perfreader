Parser for HotSpot jvmstat performance counter (hsperfdata)

# How to Build

```
$ export JAVA_HOME=/path/to/jdk
$ ant
```

# How to use

* Save hsperfdata file

```
$ java -XX:+PerfDataSaveToFile -XX:PerfDataSaveFile=<filename> ...
```

* Parse saved hsperfdata
    * `perfreader.sh` requires `$JAVA_HOME` .

```
$ perfreader.sh [hsperfdata]
```

# License

GNU General Public License v2

