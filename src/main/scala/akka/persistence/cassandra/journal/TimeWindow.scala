package akka.persistence.cassandra.journal

import java.util.Calendar
import TimeWindow._

class TimeWindow(windowDurationMillis: Long) {
  private var currentWindow = Set.empty[String]
  private var currentWindowStart = System.currentTimeMillis
  private def currentWindowEnd = currentWindowStart + windowDurationMillis

  def place(processorId: String): Placement = {
    val now = System.currentTimeMillis()
    if (now >= currentWindowEnd) {
      currentWindow = Set.empty
      currentWindowStart = now
    }

    val haveSeen = currentWindow.contains(processorId)
    if (!haveSeen) {
      currentWindow += processorId;
    }

    Placement(currentWindowStart, !haveSeen)
  }
}

object TimeWindow {
  case class Placement(windowStart: Long, isFirstOccurrenceInWindow: Boolean)
}
