package helper

/**
 * @author ShiZhan
 * configuration information
 * CHARTDATA: chart input and output data
 *
 * NOTE:
 * if above variables are not defined/exported, current directory will be used.
 */
object Config {
  import java.io.File
  import scala.util.Properties.{ envOrElse, userDir }

  val _PWD = userDir
  val chartData = new File(envOrElse("CHART_DATA", _PWD) + "/.chart")
  val CHARTDATA = chartData.getAbsolutePath

  if (!chartData.exists) chartData.mkdir
}