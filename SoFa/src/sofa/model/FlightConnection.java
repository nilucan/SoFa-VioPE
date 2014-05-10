package sofa.model;

/**
 * A flight connection between to SpecialPlaces on the map.
 *
 */
public class FlightConnection {

    protected SpecialPlace[] neighbour;

    /**
     * Create a new FlightConnection between the two given SpecialPlaces in an
     * array.
     *
     * @param neighbour an array of two SpecialPlaces connected with
     * FlightConnection. If the length of the array is not two, neighbour will
     * be left null.
     */
    public FlightConnection(SpecialPlace[] neighbour) {
        if (neighbour.length == 2) {
            this.neighbour = neighbour;
        } else {
            this.neighbour = null;
        }
    }

    /**
     * Create a new FlightConnection between the two given SpecialPlaces.
     *
     * @param endOne One end of the path
     * @param endTwo Other end of the path
     */
    public FlightConnection(SpecialPlace endOne, SpecialPlace endTwo) {

        neighbour = new SpecialPlace[2];
        neighbour[0] = endOne;
        neighbour[1] = endTwo;

    }

    /**
     * Return the destination of this flight connection, based on the given
     * starting point
     *
     * @param startingPoint Place to start the flight from
     * @return destination Place
     */
    public SpecialPlace getDestination(Place startingPoint) {
        if (neighbour[0] == startingPoint) {
            return neighbour[1];
        } else {
            return neighbour[0];
        }
    }

    /**
     * Check if this and another flightConnection are actually the same, by
     * checking the endpoints of both.
     *
     * @param flightConnection Another flightConnection to compare this to.
     * @return boolean, true if flightConnections are the same.
     */
    public boolean flightEquals(FlightConnection flightConnection) {

        return this.neighbour[0] == flightConnection.neighbour[0] && this.neighbour[1] == flightConnection.neighbour[1]
                || this.neighbour[0] == flightConnection.neighbour[1] && this.neighbour[1] == flightConnection.neighbour[0];
    }

}
