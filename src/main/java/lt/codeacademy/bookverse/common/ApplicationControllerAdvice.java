package lt.codeacademy.bookverse.common;

import java.beans.PropertyEditor;
import java.util.Date;
import lt.codeacademy.bookverse.book.exception.BookNotFoundException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler
    public String bookNotFound(BookNotFoundException e, Model model) {
        model.addAttribute("bookUUID", e.getBookUUID());
        return "book/error/bookNotFound";
    }

    @ExceptionHandler
    public String otherErrors(Exception e) {
        throw new RuntimeException(e);
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, trimmerEditor);
    }
}
