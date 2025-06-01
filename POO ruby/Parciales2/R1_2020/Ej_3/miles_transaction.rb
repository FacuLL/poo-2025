# frozen_string_literal: true

class MilesTransaction
  include Comparable

  def initialize (origin, destination, miles)
    @origin = origin
    @destination = destination
    @miles = miles
  end

  def to_s
    "From #{@origin} to #{@destination} Earned #{miles} miles"
  end

  def <=>(other)
    other.miles <=> @miles
  end

  attr_reader :miles
end
