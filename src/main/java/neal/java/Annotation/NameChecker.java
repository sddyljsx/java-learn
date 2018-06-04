package neal.java.Annotation;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner8;

import static javax.tools.Diagnostic.Kind.NOTE;

public class NameChecker {

    private final Messager messager;

    NameCheckScanner nameCheckerScanner = new NameCheckScanner();

    public NameChecker(ProcessingEnvironment processingEnvironment){
        this.messager = processingEnvironment.getMessager();

    }

    public void checkNames(Element element){
        nameCheckerScanner.scan(element);
    }

    private class NameCheckScanner extends ElementScanner8<Void,Void> {


        @Override
        public Void visitType(TypeElement e, Void aVoid) {
            checkCamelCase(e,true);
            return super.visitType(e, aVoid);
        }

        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {
            return super.visitExecutable(e, aVoid);
        }

        @Override
        public Void visitVariable(VariableElement e, Void aVoid) {
            return super.visitVariable(e, aVoid);
        }

        private void checkCamelCase(Element element, boolean initialCaps){
            String name = element.getSimpleName().toString();
            messager.printMessage(NOTE,"begin compile class " + name,element);
        }
    }
}
