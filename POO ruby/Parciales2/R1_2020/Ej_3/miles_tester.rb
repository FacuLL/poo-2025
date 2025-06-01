# frozen_string_literal: true
require_relative 'miles_tracker'

miles_tracker = MilesTracker.new

puts miles_tracker.status

puts '##########'

miles_tracker.add_miles_program('Smiles')
miles_tracker.add_miles('Smiles','EZE','YYZ',5563)

puts miles_tracker.status

puts '##########'

miles_tracker.add_miles_program('LATAM Pass')
miles_tracker.add_miles('LATAM Pass', 'EZE','SCL',709)
miles_tracker.add_miles('LATAM Pass', 'COR','LAX',5712)
miles_tracker.add_miles('Smiles', 'EZE','AKL',6421)
miles_tracker.add_miles('Smiles', 'AKL','EZE',6421)
puts miles_tracker.status

puts '##########'

miles_tracker.add_miles('AAdvantage', 'EZE', 'MIA', 4406)
# Aborta y en pantalla se obtiene el mensaje Invalid Miles Program

