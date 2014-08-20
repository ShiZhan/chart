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

object linechart {
  import helper.Config.CHARTDATA

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
  import helper.Config.CHARTDATA

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

//object barchart {
//  import helper.RenderEx.PatternRenderer
//  import helper.Config.CHARTDATA
//
//  def main(args: Array[String]) = {
//    val data = Seq(
//      ("A", "s0", 1), ("B", "s0", 3), ("C", "s0", 5),
//      ("D", "s0", 7), ("E", "s0", 9))
//    val dataset = data.toCategoryDataset
//    val bChart = BarChart(
//      dataset,
//      title = "Example Chart of Some Bars",
//      domainAxisLabel = "X",
//      rangeAxisLabel = "Y")
//    val jfc = bChart.peer
//    jfc.getLegend.setPosition(RectangleEdge.RIGHT)
//    jfc.backgroundPaint = Color.white
//    val plot = bChart.plot
//    plot.setBackgroundPaint(Color.white)
//    plot.setRangeGridlinePaint(Color.blue)
//    plot.setRenderer(new PatternRenderer)
//    bChart.show
//    bChart.saveAsPDF(CHARTDATA + "/barchart.pdf", (500, 375))
//  }
//}
//
//object multibarchart {
//  import helper.RenderEx.PatternRenderer
//  import helper.Config.CHARTDATA
//
//  def main(args: Array[String]) = {
//    val data = List(
//      ("C1", "A", 3), ("C1", "B", 4), ("C1", "C", 3),
//      ("C2", "A", 7), ("C2", "B", 8), ("C2", "C", 8))
//    val dataset = data.toCategoryDataset
//    val bChart = BarChart(
//      dataset,
//      domainAxisLabel = "X",
//      rangeAxisLabel = "Y")
//    val jfc = bChart.peer
//    jfc.getLegend.setPosition(RectangleEdge.RIGHT)
//    jfc.backgroundPaint = Color.white
//    val plot = bChart.plot
//    plot.setBackgroundPaint(Color.white)
//    plot.setRangeGridlinePaint(Color.lightGray)
//    plot.setRenderer(new PatternRenderer)
//    bChart.show
//    bChart.saveAsPDF(CHARTDATA + "/multibarchart.pdf", (500, 375))
//  }
//}
