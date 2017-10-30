# dw-book-service
Sample service that implements the backend of a booking system using Dropwizard framework.

Uses:
1) Google guice for dependency injection
2) Couchbase for persistence

APIs:
1) book (books a ticket for a particular show)
2) cancel (cancels a ticket for a particular show)

Possible Improvements:
1) Better error handling - more exceptions
2) Document locking - currently synchronized at single server level
3) More APIs for a fully functional system
4) Unit tests
