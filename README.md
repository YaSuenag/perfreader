# PerfReader
Parser for HotSpot jvmstat performance counter (hsperfdata)

# How to Build

```shell
$ export JAVA_HOME=/path/to/jdk
$ ant
```

# How to use

* Save hsperfdata file

```shell
$ java -XX:+PerfDataSaveToFile -XX:PerfDataSaveFile=<filename> ...
```

* Parse saved hsperfdata

```shell
$ cd dist
$ java -jar perfreader.jar <hsperfdata>
```

# License

GNU General Public License v2

