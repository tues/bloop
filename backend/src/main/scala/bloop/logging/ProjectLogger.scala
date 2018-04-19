package bloop.logging
import java.util.function.Supplier

class ProjectLogger(project: String, underlying: sbt.testing.Logger) extends xsbti.Logger {
  private[this] val prefix = s"[$project] "
  override def debug(msg: Supplier[String]): Unit = underlying.debug(prefix + msg.get)
  override def error(msg: Supplier[String]): Unit = underlying.error(prefix + msg.get)
  override def warn(msg: Supplier[String]): Unit = underlying.warn(prefix + msg.get)
  override def info(msg: Supplier[String]): Unit = underlying.info(prefix + msg.get)
  override def trace(exception: Supplier[Throwable]): Unit = underlying.trace(exception.get) // TODO
}
