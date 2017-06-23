package org.editorconfig.checker;

import static org.kohsuke.args4j.ExampleMode.ALL;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

/**
 * Main class.
 * @author Valentin Brandl
 * @since 0.1.0
 * @version $Id$
 */
public final class Checker {

    /**
     * The editorconfig file.
     */
    @Option(name = "-c",usage = "Config file (default: .editorconfig)")
    private String config = ".editorconfig";

    /**
     * The target directory.
     */
    @Option(name = "-d",usage = "Usage directory on which to operate (default: .)")
    private File dir = new File(".");

    /**
     * Flag if fixes should be applied.
     */
    @Option(name = "-fix",usage = "Fix some non-conform files")
    private boolean fix;

    @Argument
    private List<String> arguments = new ArrayList<>();

    public static void main(final String[] args) {
        System.exit(new Checker().doMain(args));
    }

    /**
     * Executes the main logic.
     * @param args The command line arguments
     * @return The exit code
     */
    public int doMain(final String... args) {
        final CmdLineParser parser = new CmdLineParser(this);

        parser.setUsageWidth(80);

        try {
            parser.parseArgument(args);

            if (arguments.isEmpty()) {
                throw new CmdLineException(parser, "No argument is given");
            }
        } catch (final CmdLineException cle) {
            System.err.println(cle.getMessage());
            System.err.println();

            parser.printUsage(System.err);
            System.err.println();

            System.err.println("  Example: java -jar this.jar" + parser.printExample(ALL));
            return 1;
        }

        System.out.println(config);

        System.out.println(dir);

        System.out.println(fix);

        return 0;
    }

}
