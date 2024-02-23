package lt.codeacademy.bookverse.security.service;

public interface Encoder {

    String encode(CharSequence rawPassword);
}
