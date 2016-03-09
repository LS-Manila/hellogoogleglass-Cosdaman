v0.1
added image view

v0.2
changed voice command
added screenshots

v0.3
forgot to update readme
gps acquisition is based on cell network signal and gps of companion phone.
multithreading used to refresh gps coordinates approximately every 5 seconds
notes for the future:
change imageview into canvasview; image view is not ideal, or unable to produce maps

v0.4
changed imageview to canvas to allow drawing on canvas

v0.5
attempt to fix layout (WIP)
added screenshots

v0.6
attempted to fix layout for long amount of time only to find out cardbuilder was messing with me
main page layout fixed
fix

v0.7
having trouble finding out right resolution for bitmap conversion, bitmaps have a max resolution of 2048x2048 to display on glass
experimenting with different resolutions of jpg to bmp conversions.
1.6k by something that is jpg = rescale to 5/6

v0.7a
temporary fix for map, used a downscaled map for displaying, will probably turn into tiled bitmap in the future




OPTIONAL PENDING:
tiled bitmap for world map of dlsu, for better zoom and resolution


NOTES:
Current Map Resolution is 1168, 531
	
A(Upper Left) @ 280, 120 
B(Lower Left) @ 280, -673
C(Lower Right) @ -1468, -673
D(Upper Right) @ -1468, 120 

when i input 0,0; i will go to 280, 120
1168 + x = -1468