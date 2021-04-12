import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**
 * Talking Robot: <br>
 * The Clock class is a "stub" for a class that should return the
 * hour of the current time of day as represented by a 24-hour clock
 * (in other words, in the range of 0 .. 23).  An object of this class,
 * however, can be set to generate random times for testing purposes,
 * instead of always returning the current hour, or can be set to return
 * times from a pre-defined set of test cases.
 * <br> <br>
 * Created: <br>
 *   17 December 2015,  Alyce Brady<br>
 * 
 * @author Alyce Brady
 * @version 17 December 2015
 */
public class Clock
{
    // Define constants used throughout this class.
    private final int HOURS_PER_DAY = 24;
    private final int MINS_PER_HOUR = 60;

    // Define the instance variables that compose the object's state.
    private Random generator = new Random();
    private boolean randomizing = false;
    private ArrayList<Integer> testTimes = new ArrayList<Integer>();
    private int testIterator = 0;
    private int hr;
    private int min;

    /**
     * Construct a clock that knows about the current time.
     */
    public Clock()
    {
        // Initialize clock to return current time.
        Calendar now = Calendar.getInstance();
        this.hr = now.get(Calendar.HOUR_OF_DAY);
        this.min = now.get(Calendar.MINUTE);
    }

    /**
     * Puts the clock in a "randomizing" state, where it returns random
     * times rather than the current time.
     */
    public void randomizeTimes()
    {
        this.randomizing = true;

        // Set hr to a number from 9 - 23 and min to a number from 0 to 59.
        this.hr = this.generator.nextInt(HOURS_PER_DAY);
        this.min = this.generator.nextInt(MINS_PER_HOUR);
    }

    /**
     * Add a specific hour to the test suite (the test suite just
     * contains hours, not minutes).
     *      @param  hour   hour to add to the test suite (0 - 23)
     */
    public void addTestCase(int hr)
    {
        // Double-check that we have a valid parameter (aka argument).
        if ( this.hr < 0 || this.hr > 23 )
        {
            throw new IllegalArgumentException("Invalid hour parameter: " + hr);
        }

        // The parameter represents a valid test case.
        this.randomizing = false;
        this.testIterator = 0;
        this.testTimes.add(hr);
    }

    /**
     * Returns the number of test cases that have been added.
     *      @return  the number of test cases added with addTestCase
     */
    public int getNumTestCases()
    {
        return testTimes.size();
    }

    /**
     * Change clock to another time.
     * This method advances the clock to the next minute, unless the
     * clock has been set to randomize times or use a test suite.  If
     * the clock is randomizing times, this method will generate a new,
     * random time.  If the clock is using a test suite, it will advance
     * to the next time in the test suite until it reaches the end, at
     * which point it will start issuing random times instead.
     */
    public void changeTime()
    {
        // Handle the special cases first:

        // Is the clock using a test suite of pre-defined times (hours)?
        if ( this.testTimes.size() > 0 )
        {
            // Have we run through all the tests yet?
            if ( this.testIterator >= this.testTimes.size() )
            {
                // Yes, so switch to randomizing.
                this.randomizing = true;
            }
            else
            {
                // No -- move on to the next test in the test suite.
                this.hr = this.testTimes.get(this.testIterator);
                this.testIterator++;
                return;
            }
        }

        // Is the clock returning random times?
        if ( this.randomizing )
        {
            // Change to random hour and minute.
            this.hr = this.generator.nextInt(HOURS_PER_DAY);
            this.min = this.generator.nextInt(MINS_PER_HOUR);
        }
        else    // This is not a special case, so move forward 1 minute.
        {
            // Advance clock by 1 minute.
            this.min = (this.min + 1) % MINS_PER_HOUR;

            // Handle cases of going rolling over to next hour or next day.
            if ( this.min == 0 )
            {
                this.hr = (this.hr + 1) % HOURS_PER_DAY;
            }
        }
    }

    /**
     * Returns an hour in the range of 0 - 23.  Returns
     * the current time of day, but is actually a random hour.)
     * 
     * @return     the hour 
     */
    public int getHour()
    {
        return this.hr;
    }

    /**
     * Returns a minute in the range of 0 - 59.  (Should be the hour of
     * the current time of day, but is actually a random hour.)
     * 
     * @return     the minute 
     */
    public int getMinute()
    {
        return this.min;
    }

    /**
     * Returns the current hour in 12-hour HH format (01 - 12).
     * 
     * @return     the hour in HH format
     */
    public String getHH()
    {
        int adjustedHr = this.hr;
        if ( this.hr == 0 )
            adjustedHr = 12;
        else if ( this.hr > 12 )
            adjustedHr = this.hr - 12;
        return String.format("%02d", adjustedHr);
    }

    /**
     * Returns the current minute in MM format (00 - 59).
     * 
     * @return     the minute in MM format
     */
    public String getMM()
    {
        return String.format("%02d", this.min);
    }

    /**
     * Sets the time to an hour in the range of 0 - 23.
     * 
     *      @param  hour   hour to set the clock to (0 - 23)
     */
    public void setHour(int hour)
    {
        // Double-check that we have a valid parameter (aka argument).
        if ( hour < 0 || hour >= HOURS_PER_DAY )
        {
            throw new IllegalArgumentException("Invalid hour parameter: " + hour);
        }

        this.hr = hour;
    }

    /**
     * Sets the time to a minute in the range of 0 - 59.
     * 
     *      @param  minute   minute to set the clock to (0 - 59)
     */
    public void setMinute(int minute)
    {
        // Double-check that we have a valid parameter (aka argument).
        if ( minute < 0 || minute >= MINS_PER_HOUR )
        {
            throw new IllegalArgumentException("Invalid minute parameter: " + minute);
        }

        this.min = minute;

    }


}
