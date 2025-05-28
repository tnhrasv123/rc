[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Loaded 5442 aliases in 896ms
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 86: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: if size of {race::players::*} < {@min_players_to_start}:
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 87: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: broadcast "{@prefix} &cCannot start race: Not enough players. Need %{@min_players_to_start}%, have %{size of {race::players::*}}%"
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 88: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: return
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 90: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {race::track_id} to {_track_id}
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 91: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {race::status} to "countdown"
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 92: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: broadcast "{@prefix} &eRace on track &6%{tracks::%{_track_id}%::name}% &estarting in %{@countdown_seconds}% seconds!"
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 94: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: loop {@countdown_seconds} times:
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 95: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_remaining_time} to {@countdown_seconds} - (loop-number - 1)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 96: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: broadcast "{@prefix} &eRace starting in &c%{_remaining_time}%..."
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 97: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: loop {race::players::*}:
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 98: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_p_in_loop} to loop-value-1# Corrected loop-value to loop-value-1
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 99: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: send title "&c%{_remaining_time}%" to {_p_in_loop} for 20 ticks
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 100: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: play sound "block.note_block.pling" to {_p_in_loop} with pitch ((loop-number / {@countdown_seconds}) * 0.5) + 0.5# Pitch increases
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 101: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: wait 1 second
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 103: (core\racing.sk)
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: triggerRaceStart({_track_id})
[16:50:05] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 92: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: if {_cond_type} is "clicks":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 93: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::clicks} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 94: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_cond_type} is "speed_level":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 95: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::speed_level} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 96: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_cond_type} is "autoclicker_level":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 97: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::autoclicker_level} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 98: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_cond_type} is "races_won":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 99: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::races_won} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 100: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_cond_type} is "races_participated":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 101: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::total_races_participated} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 102: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_cond_type} is "prestige_level":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 103: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::prestige_level} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 104: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_cond_type} is "track_wins":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 105: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::track_wins} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 106: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_cond_type} is "track_time":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 107: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::track_time} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 108: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_cond_type} is "max_combo":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 109: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::max_combo} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 110: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_cond_type} is "multiplayer_wins":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 111: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::multiplayer_wins} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 112: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_cond_type} is "all_tracks":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 113: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::completed_tracks} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 114: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_cond_type} is "track_record":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 115: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::track_records} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 116: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_cond_type} is "combo_record":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 117: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_player_val} to {player::%{_uuid}%::combo_records} ? 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 119: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: if {_player_val} >= {_cond_val}:
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 120: (features\achievements.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: tryUnlockAchievement({_p}, {_id})
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 130: (features\pets.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_last_spawned_pet} to tame# Fix invalid expression 'set ... to be tame'
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 131: (features\pets.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set owner of {_last_spawned_pet} to {_p}
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 132: (features\pets.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {pet_entities::%{_last_spawned_pet}'s uuid%} to "%{_uuid}%:%{_pet_id}%"# Store playerUUID:petID
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 135: (features\pets.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: if {_pet_entity_type_str} is "PLAYER_HEAD" or {_pet_entity_type_str} is "player_head":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 136: (features\pets.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: if {pet::%{_pet_id}%::skin_data} is set:
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 144: (features\pets.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: pass
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 146: (features\pets.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: add {_pet_id} to {player::%{_uuid}%::pets::active::*}
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 147: (features\pets.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: send "{@prefix} &aPet %{pet::%{_pet_id}%::name}% &aactivated!" to {_p}
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 150: (features\pets.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: play sound "minecraft:entity.wolf.howl" to {_p} with volume 0.8 pitch 1.2
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 152: (features\pets.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 4 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: refreshPlayerPetBonuses({_p})
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 202: (features\tournaments.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 28 spaces, but found 29 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_match_display} to "&e    Match %{_match_idx}%: &f%{_p1_name}% &7(BYE - Auto-advances)"
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 201: (features\tournaments.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Empty configuration section! You might want to indent one or more of the subsequent lines to make them belong to this section or remove the colon at the end of the line if you don't want this line to start a section.
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: if {_p2_uuid} is not set and {_status} is "finished_bye":# Explicit bye display
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 518: (guilds\guild_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 8 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_reward} to {guild::%{_guild}%::level} * 1000
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 519: (guilds\guild_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 8 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: add {_reward} to {guild::%{_guild}%::bank}
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 522: (guilds\guild_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 8 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: loop {guild::%{_guild}%::members::*}:
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 523: (guilds\guild_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 8 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: send "{@prefix} &6Guild level up! New level: %{guild::%{_guild}%::level}%" to loop-value
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 524: (guilds\guild_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 8 spaces, but found 16 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: send "{@prefix} &6Guild bank received %{_reward}% ClickCoins!" to loop-value
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 155: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&eClicks: &a%{_clicks}%/%{_req_clicks}%\n" +
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 156: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&eRaces Won: &a%{_races_won}%/%{_req_races}%\n" +
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 157: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&eTracks Completed: &a%{_tracks_completed}%/%{_req_tracks}%\n" +
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 158: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&eAchievements: &a%{_achievements}%/%{_req_achievements}%\n" +
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 159: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&eMax Combo: &a%{_max_combo}%/%{_req_combo}%\n" +
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 160: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&eTime Played: &a%{_total_time}%/%{_req_time}%\n" +
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 161: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&eMultiplayer Wins: &a%{_multiplayer_wins}%/%{_req_wins}%"
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 217: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&ePower Bonus: &a+%{_power_bonus}x\n" +
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 218: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&eSpeed Bonus: &a+%{_speed_bonus}x\n" +
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 219: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&eCombo Bonus: &a+%{_combo_bonus}x\n" +
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 220: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&eAccuracy Bonus: &a+%{_accuracy_bonus}x\n" +
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 221: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&ePoints Bonus: &a+%{_points_bonus}\n" +
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 222: (prestige\prestige_eligibility.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 4 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: "&eAchievement Bonus: &a+%{_achievement_bonus}" to {_p}
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 135: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: if {_season} contains "Spring":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 136: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_points} to {_points} * {@seasonal_bonuses::spring}
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 137: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_season} contains "Summer":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 138: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_points} to {_points} * {@seasonal_bonuses::summer}
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 139: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_season} contains "Autumn":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 140: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_points} to {_points} * {@seasonal_bonuses::autumn}
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 141: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: else if {_season} contains "Winter":
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 142: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {_points} to {_points} * {@seasonal_bonuses::winter}
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 145: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: add {_points} to {player::%{_uuid}%::season_points}
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 148: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {player::%{_uuid}%::clicks} to 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 149: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {player::%{_uuid}%::races} to 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 150: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 8 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: set {player::%{_uuid}%::wins} to 0
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]: [Skript] Line 152: (seasons\seasonal_system.sk)
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     indentation error: expected 0 spaces, but found 12 spaces
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:     Line: updateSeasonRank({_p})
[16:50:06] [ForkJoinPool.commonPool-worker-2/INFO]:  