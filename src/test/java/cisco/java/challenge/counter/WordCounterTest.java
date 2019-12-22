package cisco.java.challenge.counter;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WordCounterTest {

 private WordCounter wordCounter = new WordCounter();

    @Test
    public void testBlankText() {
        String text = "             \n  \t \r\n";

        Map<String, Integer> result = wordCounter.count(text);

        assertTrue(result.isEmpty());
    }


    @Test
    public void testCounting() {
        String text = "One ,five six two, three six five    two four  ,six,five thRee six four SIX four four five six three five/";

        Map<String, Integer> result = wordCounter.count(text);

        assertThat(result.size()).isEqualTo(6);
        assertThat(result.get("one")).isEqualTo(1);
        assertThat(result.get("two")).isEqualTo(2);
        assertThat(result.get("three")).isEqualTo(3);
        assertThat(result.get("four")).isEqualTo(4);
        assertThat(result.get("five")).isEqualTo(5);
        assertThat(result.get("six")).isEqualTo(6);
    }
}