/*
 * Copyright (C) 2016 Yasumasa Suenaga
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */
package jp.dip.ysfactory.perfreader;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.channels.FileChannel;

import sun.jvmstat.monitor.Units;
import sun.jvmstat.monitor.Monitor;
import sun.jvmstat.monitor.MonitorException;
import sun.jvmstat.perfdata.monitor.AbstractPerfDataBuffer;


public class PerfReader{

  public static class HSPerfDataBuffer extends AbstractPerfDataBuffer{

    public HSPerfDataBuffer(ByteBuffer buffer) throws MonitorException{
      super();
      super.createPerfDataBuffer(buffer, -1);
    }

  }

  private static void printMonitor(Monitor monitor){
    System.out.print(monitor.getName());
    System.out.print(" = ");
    System.out.print(monitor.getValue());

    Units unit = monitor.getUnits();

    if((unit.intValue() != Units.NONE.intValue()) &&
       (unit.intValue() != Units.STRING.intValue())){
      System.out.print(" (");
      System.out.print(monitor.getUnits());
      System.out.print(")");
    }

    System.out.println();
  }

  public void dumpPerfData(Path path) throws IOException, MonitorException{

    try(FileChannel ch = FileChannel.open(path, StandardOpenOption.READ)){
      ByteBuffer buffer = ch.map(FileChannel.MapMode.READ_ONLY, 0L, ch.size());
      HSPerfDataBuffer perfReaderBuffer = new HSPerfDataBuffer(buffer);
      perfReaderBuffer.findByPattern(".*")
                      .forEach(PerfReader::printMonitor);
    }

  }

}
