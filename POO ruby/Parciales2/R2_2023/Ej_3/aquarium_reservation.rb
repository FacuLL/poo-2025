# frozen_string_literal: true

class AquariumReservation
  attr_reader :visitor, :day

  def initialize(visitor, day)
    @visitor = visitor
    @day = day
  end

  def to_s
    "Aquarium Reservation of Visitor #{@visitor} for the day #{@day}"
  end

  def ==(other)
    [@visitor, @day] == [other.visitor, other.day]
  end

  alias_method :inspect, :to_s
end
