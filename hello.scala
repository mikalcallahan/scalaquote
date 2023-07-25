#!/usr/bin/env -S scala-cli -S 3

//> using toolkit latest
//> using dep com.lihaoyi::upickle:3.1.2

import upickle.default.*

case class Quote(
    author: String,
    text: String
) derives ReadWriter

case class Quotes(quotes: List[Quote]) derives ReadWriter

@main def hello(): Unit = {
  val readQuotes = read[Quotes](os.read(os.pwd / "quotes.json")) 
  val index = (new scala.util.Random).nextInt(readQuotes.quotes.length)

  println(
    s"${readQuotes.quotes(index).text}\n- ${readQuotes.quotes(index).author}"
  )

}
