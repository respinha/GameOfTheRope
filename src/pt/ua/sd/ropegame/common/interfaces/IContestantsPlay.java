package pt.ua.sd.ropegame.common.interfaces;

import pt.ua.sd.ropegame.common.VectClock;
import pt.ua.sd.ropegame.common.communication.Response;
import java.rmi.RemoteException;

/**
 * An interface every playground-like object must implement to be able to allow contestant's remote connection.
 */
public interface IContestantsPlay extends IPlayground {

    /**
     * Move a contestant to the playground.
     * @param clientClock Contestant's current clock.
     * @param gameMemberID Contestant's number.
     * @param teamID Contestant's team.
     * @param strength Contestant's strength.
     * @return Updated clock.
     * @throws RemoteException A remote exception occurred.
     */
    Response standInLine(VectClock clientClock, int gameMemberID, int teamID, int strength) throws RemoteException;

    /**
     * Wait for a referee to start the trial.
     * @param clientClock Contestant's current clock.
     * @param gameMemberID Contestant's number.
     * @param teamID Contestant's team.
     * @param strength Contestant's strength.
     * @return Updated clock + new Contestant's state.
     * @throws InterruptedException The thread was interrupted.
     * @throws RemoteException A remote exception occurred.
     */
    Response getReady(VectClock clientClock, int gameMemberID, int teamID, int strength) throws InterruptedException, RemoteException;

    /**
     * Simulate that a rope is being pulled. Wait for a random interval.
     * @param clientClock Contestant's current clock.
     * @return Updated clock.
     * @throws InterruptedException The thread was interrupted.
     * @throws RemoteException A remote exception occurred.
     */
    Response pullTheRope(VectClock clientClock) throws InterruptedException, RemoteException;

    /**
     * Called every time a contestant finishes pulling the rope.<p>
     * The last contestant to perform this operation wakes up the referee.
     * @param clientClock Contestant's current clock.
     * @return Updated clock + match is over (boolean).
     * @throws InterruptedException The thread was interrupted.
     * @throws RemoteException A remote exception occurred.
     */
    Response amDone(VectClock clientClock) throws InterruptedException, RemoteException;
}
