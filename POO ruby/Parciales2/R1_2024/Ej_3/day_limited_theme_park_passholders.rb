# frozen_string_literal: true
require_relative 'theme_park_passholders'

class DayLimitedThemeParkPassholders < ThemeParkPassholders
  def initialize(visitor, max_days)
    super(visitor)
    @max_days = max_days
    @days = 0
  end

  def add_pass(theme_park, day)
    super(theme_park, day)
    @days += 1
  end

  def is_day_occupied?(day)
    self.passes.each do
      return true if it.day == day
    end
    false
  end

  def add_pass?(theme_park, day)
    super(theme_park, day) && @days < @max_days && not is_day_occupied?(day)
  end

  private :add_pass?
end
