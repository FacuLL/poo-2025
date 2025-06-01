# frozen_string_literal: true
require_relative 'unique_days_ahead_aquarium_exhibit'

class MembersSameDayAquariumExhibit < UniqueDaysAheadAquariumExhibit
  def initialize(name, exhibition_day, members)
    super(name, exhibition_day, 0)
    @members = members
  end

  def reserve_exhibit(visitor, day)
    raise "Cannot reserve" unless is_member?(visitor)
    super(visitor, day)
  end

  private

  def is_member?(visitor)
    @members.each do
      return true if it == visitor
    end
    false
  end
end
