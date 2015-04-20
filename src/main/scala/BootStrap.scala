/**
 * Created by Sushmeet on 2015-04-19.
 */

import scala.slick.jdbc.meta.MTable
import slick.driver.MySQLDriver.simple._
object BootStrap extends App {




//  val url = "jdbc:mysql://mtl-alex01.sv.stw/billing_reports?allowMultiQueries=true"
//  val db =  Database.forURL(url, user = "sushi", password = "jbilling2", driver = "com.mysql.jdbc.Driver")


  val localurl = "jdbc:mysql://localhost/test?allowMultiQueries=true"
  val localdb = Database.forURL(localurl, user = "root", password = "sushi123", driver = "com.mysql.jdbc.Driver")

  // create a table first in slick
  case class Clients(id: Int, userName: String, name: String)

  // We need to define Table row classes for our database schema
  // This describes the structure of our database tables.
  // ClientInfo is called a Table Row Class.
  class ClientInfo (tag: Tag) extends Table[(Int,String,String)](tag, "CLIENTS_INFO") {
    def id = column[Int] ("ID")                 // All columns are defined by column method
    def userName = column[String] ("USER_NAME")
    def name = column[String] ("NAME")
    def * = (id, userName, name) // Every table requires a * method containing a dafault projection
    // It describes what you get back when you return rows from a query in the form of a table row object
    // Slick’s * projection does not have to match the one in the database.
    // You can add new columns (e.g. with computed values) or omit some columns as you like.
  }
    val clientsInfo = TableQuery[ClientInfo] //you need a TableQuery value which represents the actual database table:

  // Create a table clients_info in the database
  localdb.withSession { implicit session =>
    if (MTable.getTables("CLIENTS_INFO").list.isEmpty)
    clientsInfo.ddl.create
  }

}
