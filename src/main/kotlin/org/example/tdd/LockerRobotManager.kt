package org.example.tdd

class LockerRobotManager(
        private val lockers: List<Locker>,
        private val primaryLockerRobots: List<PrimaryLockerRobot>,
        private val superLockerRobots: List<SuperLockerRobot>
) {
    fun save(bag: Bag): Ticket {
        return when (bag.type) {
            SizeType.S -> lockers.first().save(bag)
            SizeType.M -> primaryLockerRobots.first().save(bag)
            SizeType.L -> superLockerRobots.first().save(bag)
        }
    }

    fun take(ticket: Ticket): Bag? {
        return when (ticket.type) {
            SizeType.S -> lockers.first().take(ticket)
            SizeType.M -> primaryLockerRobots.first().take(ticket)
            SizeType.L -> superLockerRobots.first().take(ticket)
            else -> null
        }
    }
}
