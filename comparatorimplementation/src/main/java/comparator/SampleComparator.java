package comparator;

import difflib.Delta;
import difflib.DiffUtils;
import difflib.Patch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class SampleComparator implements comparator.Comparator{
    public String compare(String source, String target) throws IOException {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        List<String> original = Files.readAllLines(new File(classLoader.getResource(source).getFile()).toPath());
        List<String> revised = Files.readAllLines(new File(classLoader.getResource(target).getFile()).toPath());

//compute the patch: this is the diffutils part
        Patch<String> patch = DiffUtils.diff(original, revised);

        //simple output the computed patch to console
        StringBuilder deltas = new StringBuilder("");
        for (Delta<String> delta : patch.getDeltas()) {
            deltas.append(delta).append("\n");
        }

        return String.valueOf(deltas);
    }

}
