package com.lksnext.parking;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.Is.is;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.lksnext.parking.viewmodel.ReservaViewModel;

import org.junit.Rule;
import org.junit.Test;

/**
 * Unit test that checks if the random generation function of Step2ViewModel works
 */
public class RandomNumberGeneratorTest {

    //Values should between 0 (inclusive) and 10 (exclusive)
    private static final int MIN_VALUE = -1;
    private static final int MAX_VALUE = 10;

    //Swap the background executor used by some components with a executor that executes tasks synchronously
    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    //Instantiate the Step2ViewModel class
    ReservaViewModel step2ViewModel = new ReservaViewModel();

    /**
     * Unit test that checks if the random generator generates a value between MIN and MAX values
     * @throws InterruptedException Thrown when LiveDataTestUtil's wait thread is interrupted
     */
    @Test
    public void step2ViewModelTest() throws InterruptedException {
        //Generate a random number
        step2ViewModel.generateRandomValue(null);
        //Get the value of the randomValue livedata
        Integer randomValue = LiveDataTestUtil.getValue(step2ViewModel.getRandomValue());
        System.out.println("RandomValue = " + randomValue);
        //Check if value is between the limits
        assertThat(randomValue, is(both(greaterThan(MIN_VALUE)).and(lessThan(MAX_VALUE))));
    }
}