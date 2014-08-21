/**
 * Copyright 2013 Zhan Shi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import scalax.chart.api._
import org.jfree.ui.RectangleEdge
import java.awt.Color
import util.Random
import helper.Config.CHARTDATA

object linechart {
  def main(args: Array[String]) = {
    val data = Vector("Y" -> Vector.tabulate(5)((_, Random.nextInt(10))))
    val lChart = XYLineChart(data)
    lChart.plot.getDomainAxis.setLabel("X")
    lChart.plot.getRangeAxis.setLabel("Y")
    val jfc = lChart.peer
    jfc.getLegend.setPosition(RectangleEdge.RIGHT)
    jfc.setBackgroundPaint(Color.white)
    val plot = lChart.plot
    plot.setBackgroundPaint(Color.white)
    plot.setDomainGridlinePaint(Color.blue)
    plot.setRangeGridlinePaint(Color.blue)
    lChart.show("Example Chart", (500, 375), false)
    lChart.saveAsPDF(CHARTDATA + "/linechart.pdf", (500, 375))
  }
}

object multilinechart {
  import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer

  def main(args: Array[String]) = {
    val dataA = Vector.tabulate(9)(i => (i, i))
    val dataB = Vector.tabulate(9)(i => (i, 9 - i))
    val data = Vector("Line A" -> dataA, "Line B" -> dataB)
    val lChart = XYLineChart(data)
    val jfc = lChart.peer
    jfc.getLegend.setPosition(RectangleEdge.RIGHT)
    jfc.setBackgroundPaint(Color.white)
    val plot = lChart.plot
    plot.setBackgroundPaint(Color.white)
    plot.setDomainGridlinePaint(Color.lightGray)
    plot.setRangeGridlinePaint(Color.lightGray)
    plot.setRenderer(new XYLineAndShapeRenderer)
    lChart.show("Example Chart", (500, 375), false)
    lChart.saveAsPDF(CHARTDATA + "/multilinechart.pdf", (500, 375))
  }
}

object areachart {
  import helper.RenderEx.GrayStackedAreaRenderer

  def randomVector = Vector.tabulate(9)(i => (i, Random.nextInt(10)))

  def main(args: Array[String]) = {
    val data = Vector("A" -> randomVector, "B" -> randomVector, "C" -> randomVector, "D" -> randomVector)
    val chart = AreaChart.stacked(data)
    val jfc = chart.peer
    jfc.getLegend.setPosition(RectangleEdge.RIGHT)
    jfc.setBackgroundPaint(Color.white)
    val plot = chart.plot
    plot.setBackgroundPaint(Color.white)
    plot.setRenderer(new GrayStackedAreaRenderer)
    chart.show("Example Chart", (500, 375), false)
    chart.saveAsPDF(CHARTDATA + "/areachart.pdf", (500, 375))
  }
}

object barchart {
  import helper.RenderEx.BarPatternRenderer

  def main(args: Array[String]) = {
    val data = Vector("s0" -> Vector.tabulate(5)(i => ((i + 'A').toChar, Random.nextInt(10))))
    val bChart = BarChart(data)
    bChart.plot.getDomainAxis.setLabel("X")
    bChart.plot.getRangeAxis.setLabel("Y")
    val jfc = bChart.peer
    jfc.getLegend.setPosition(RectangleEdge.RIGHT)
    jfc.setBackgroundPaint(Color.white)
    val plot = bChart.plot
    plot.setBackgroundPaint(Color.white)
    plot.setRangeGridlinePaint(Color.blue)
    plot.setRenderer(new BarPatternRenderer)
    bChart.show("Example Chart of Some Bars", (500, 375), false)
    bChart.saveAsPDF(CHARTDATA + "/barchart.pdf", (500, 375))
  }
}

object multibarchart {
  import helper.RenderEx.BarPatternRenderer

  def main(args: Array[String]) = {
    val data = Vector(
      "C1" -> Vector.tabulate(3)(i => ((i + 'A').toChar, Random.nextInt(10))),
      "C2" -> Vector.tabulate(3)(i => ((i + 'A').toChar, Random.nextInt(10))))
    val bChart = BarChart(data)
    bChart.plot.getDomainAxis.setLabel("X")
    bChart.plot.getRangeAxis.setLabel("Y")
    val jfc = bChart.peer
    jfc.getLegend.setPosition(RectangleEdge.RIGHT)
    jfc.setBackgroundPaint(Color.white)
    val plot = bChart.plot
    plot.setBackgroundPaint(Color.white)
    plot.setRangeGridlinePaint(Color.lightGray)
    plot.setRenderer(new BarPatternRenderer)
    bChart.show("Example Chart of Some Bars", (500, 375), false)
    bChart.saveAsPDF(CHARTDATA + "/multibarchart.pdf", (500, 375))
  }
}

object piechart {
  def main(args: Array[String]) = {
    val data = Vector.tabulate(8)(i => ((i + 'A').toChar, Random.nextInt(10)))
    val chart = PieChart(data)
    val jfc = chart.peer
    jfc.getLegend.setPosition(RectangleEdge.RIGHT)
    jfc.setBackgroundPaint(Color.white)
    val plot = chart.plot
    plot.setBackgroundPaint(Color.white)
    plot.setShadowPaint(Color.white)
    chart.show("Example Pie Chart", (500, 375), false)
    chart.saveAsPDF(CHARTDATA + "/piechart.pdf", (500, 375))
  }
}
