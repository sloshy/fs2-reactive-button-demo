package dev.rpeters.fs2.button

import cats.implicits._
import cats.effect._
import org.scalajs.dom.document
import fs2.concurrent.Queue
import org.scalajs.dom.raw.Event

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    def renderButton(i: Int, increment: IO[Unit]) = IO {
      val liveDemo = document.getElementById("live-demo")
      val button = document.getElementById("live-demo-button")
      if (button != null) {
        liveDemo.removeChild(button)
      }
      val newButton = document.createElement("button")
      newButton.innerText = i.toString
      newButton
        .addEventListener(
          "click",
          listener = (e: Event) => increment.unsafeRunAsyncAndForget()
        )
      newButton.id = "live-demo-button"
      liveDemo.appendChild(newButton)
    }

    for {
      q <- Queue.unbounded[IO, Int]
      _ <- q.dequeue
        .scan(0)(_ + _)
        .evalTap(i => renderButton(i, q.enqueue1(1)))
        .compile
        .drain
    } yield ExitCode.Error
  }
}
