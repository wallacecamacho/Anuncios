package br.com.anuncios.exception;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;

import org.jboss.solder.exception.control.CaughtException;
import org.jboss.solder.exception.control.Handles;
import org.jboss.solder.exception.control.HandlesExceptions;
import org.jboss.solder.exception.control.TraversalMode;

/**
 * A sample Exception Handler container, using the typical means of declaring handlers.
 */
@HandlesExceptions
public class StandardHandlerDeclaration
{
   final ResourceBundle messages = ResourceBundle.getBundle("org.jboss.seam.exception.example.basic.servlet.messages");

   public void throwableHandler(@Handles(during = TraversalMode.BREADTH_FIRST) CaughtException<Throwable> event,
                                HttpServletResponse response)
   {
      HandlerOutput.printToResponse(this.messages, event.getException(), response, "throwableHandler", "markHandled");

      event.unmute();
      event.markHandled();
   }

   public void assertionErrorHandler(@Handles CaughtException<AssertionError> event,
                                     HttpServletResponse response)
   {
      HandlerOutput.printToResponse(this.messages, event.getException(), response, "assertionErrorHandler", "rethrow");

      event.rethrow();
   }

   public void nullPointerHandler(@Handles CaughtException<NullPointerException> event, HttpServletResponse response)
   {
      HandlerOutput.printToResponse(this.messages, event.getException(), response, "nullPointerHandler", "handled");

      event.handled();
   }

   public void illegalArgumenBreadthFirsttHandler(@Handles(during = TraversalMode.BREADTH_FIRST) CaughtException<IllegalArgumentException> event, HttpServletResponse response)
   {
      HandlerOutput.printToResponse(this.messages, event.getException(), response, "illegalArgumentBreadthFirstHandler", "dropCause");

      event.dropCause();
   }

   public void illegalArgumentHandler(@Handles CaughtException<IllegalArgumentException> event, HttpServletResponse response)
   {
      HandlerOutput.printToResponse(this.messages, event.getException(), response, "illegalArgumentHandler", "handled");

      event.handled();
   }

   public void illegalStateHandler(@Handles CaughtException<IllegalStateException> event, HttpServletResponse response)
   {
      HandlerOutput.printToResponse(this.messages, event.getException(), response, "illegalStateHandler", "abort");

      event.abort();
   }

   public void ioExceptionHandler(@Handles CaughtException<IOException> event, HttpServletResponse response)
   {
      HandlerOutput.printToResponse(this.messages, event.getException(), response, "illegalStateHandler", "rethrow(new ArithmeticException)");

      event.rethrow(new ArithmeticException("Re-thrown"));
   }
}
