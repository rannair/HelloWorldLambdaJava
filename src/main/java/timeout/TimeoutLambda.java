package timeout;

import com.amazonaws.services.lambda.runtime.Context;

public class TimeoutLambda {

    public void handleTimeOut(Context context) throws InterruptedException {

        while (true) {
            Thread.sleep(100);
            System.out.println(" Time remaining -->" + context.getRemainingTimeInMillis());
        }

    }
}
