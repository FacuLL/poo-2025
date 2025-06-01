# frozen_string_literal: true

class RejectedTicket < TrainTicket
  def initialize(origin, destination, passenger)
    super(origin, destination, passenger)
  end

  def to_s
    "Rejected Ticket from #{@origin} to #{@destination} for #{@passenger}"
  end
end
