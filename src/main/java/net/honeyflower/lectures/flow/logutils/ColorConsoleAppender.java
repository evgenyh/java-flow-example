package net.honeyflower.lectures.flow.logutils;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.spi.LoggingEvent;

import net.honeyflower.lectures.flow.MagazineSubscriber;

public class ColorConsoleAppender extends ConsoleAppender {

  @Override
  protected void subAppend(final LoggingEvent event) {
    int color = 36;
    if (event.getRenderedMessage().contains(MagazineSubscriber.JACK)) {
      color = 32;
    } else if (event.getRenderedMessage().contains(MagazineSubscriber.PETE)) {
      color = 31;
    }
    qw.write("\u001b[0;" + color + "m");
    super.subAppend(event);
    qw.write("\u001b[m");
    if (this.immediateFlush) qw.flush();
  }

}
