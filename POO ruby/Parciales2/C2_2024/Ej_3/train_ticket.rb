# frozen_string_literal: true

class TrainTicket
  def initialize(origin, destination, passenger)
    @origin = origin
    @destination = destination
    @passenger = passenger
  end

  def to_s
    "Ticket from #{@origin} to #{@destination} for #{@passenger}"
  end

  def <=>(other)
    [@origin, @destination, other.passenger] <=> [other.origin, other.destination, @passenger]
  end

  attr_reader :destination, :passenger, :origin
end
