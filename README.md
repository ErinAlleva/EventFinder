# EventFinder
run in eclipse, or compile both Event.java and FindEvents.java and run in command line.

The program will ask for user input in the form x,y and does a bit of error checking to account for bad input. 
The program will then return the 5 closest events with the cheapest price and the coordinates of the event location.

I assumed we only wanted to create 200 events and for each event the most tickets(different ticket prices) would be 24, however this
was random for each event. When creating the data I assumed that if an event with the same coordinates was created we would just ignore
it and not add it to the list of events. I assumed ticket prices would be between $30 and $230. 

# <**How might you change your program if you needed to support multiple events at the
same location?**>

Because of how my Event objects were created I would just allow events with the same coordinates to be added to the list of 
events. 

# <**How would you change your program if you were working with a much larger world
size?**>



