package friendsofmine.m2.exceptions;

// @ResponseStatus(HttpStatus.NOT_FOUND)
public class InscriptionNotFoundException extends RuntimeException {

    public InscriptionNotFoundException(Long InscriptionId) {
        super("Could not find exception" + InscriptionId + ".");
    }
}
