# frozen_string_literal: true
require_relative 'aquarium_exhibit'

class UniqueDaysAheadAquariumExhibit < AquariumExhibit
  def initialize(name, exhibition_day, limit_days)
    super(name)
    @limit_days = limit_days
    @exhibition_day = exhibition_day
  end

  def reserve_exhibit(visitor, day)
    raise "Cannot reserve" unless is_day_in_range?(day)
    raise "Cannot reserve" if visitor_already_reserve?(visitor, day)
    super(visitor, day)
  end

  private

  def is_day_in_range?(day)
    ((@exhibition_day - @limit_days)..(@exhibition_day)) === day
  end

  def visitor_already_reserve?(visitor, day)
    self.reservations.each do
      return true if visitor == it.visitor && day == it.day
    end
    false
  end
end
