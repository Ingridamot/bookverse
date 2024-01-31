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
    public String productNotFound(BookNotFoundException e, Model model) {
        model.addAttribute("productUUID", e.getBookUUID());
        return "product/error/productNotFound";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

}

