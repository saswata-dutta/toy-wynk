user
    id
    name

artist
    id
    name

song
    id
    name

playlist (join table)
    id
    name
    user-id

playlist-song (join table)
    playlist-id
    song-id

follows
    user-id
    artist-id

published
    artist-id
    song-id
