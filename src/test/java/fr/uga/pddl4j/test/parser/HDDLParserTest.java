package test.java.fr.uga.pddl4j.test.parser;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.planners.ProblemFactory;

import java.io.IOException;


/**
 * Created by pellier on 18/12/2019.
 */
public class HDDLParserTest {

    public static void main(String[] args) {

        ErrorManager errorManager = null;

        final ProblemFactory factory = ProblemFactory.getInstance();
        try {
           errorManager  = factory.parse(
                "src/test/resources/parser/hddl/HDDL-Total-Ordered/rover/domain.hddl",
                "src/test/resources/parser/hddl/HDDL-Total-Ordered/rover/pb01.hddl");

            errorManager  = factory.parse(
                "src/test/resources/parser/hddl/HDDL-Total-Ordered/transport/domain.hddl",
                "src/test/resources/parser/hddl/HDDL-Total-Ordered/transport/pb01.hddl");

            errorManager  = factory.parse(
                "src/test/resources/parser/hddl/HDDL-Partial-Ordered/rover/domain.hddl",
                "src/test/resources/parser/hddl/HDDL-Partial-Ordered/rover/pb01.hddl");

            errorManager  = factory.parse(
                "src/test/resources/parser/hddl/HDDL-Partial-Ordered/transport/domain.hddl",
                "src/test/resources/parser/hddl/HDDL-Partial-Ordered/transport/pb01.hddl");

            if (!errorManager.isEmpty()) {
                errorManager.printAll();
                System.exit(0);
            } else {
                System.out.println("Parsing domain file and problem file done successfully");
            }

        } catch (IOException e) {
            System.out.println("Unexpected error when parsing the PDDL planning problem description.");
            System.exit(0);
        }

    }
}
